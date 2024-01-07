package hello.jwt_example.service.auth;

import hello.jwt_example.common.util.BcryptUtil;
import hello.jwt_example.common.util.JwtTokenUtil;
import hello.jwt_example.domain.member.Member;
import hello.jwt_example.domain.member.MemberRepository;
import hello.jwt_example.domain.member.MemberStatus;
import hello.jwt_example.service.auth.dto.SignInRequest;
import hello.jwt_example.service.auth.dto.SignInResponse;
import hello.jwt_example.service.auth.dto.SignUpRequest;
import hello.jwt_example.service.auth.dto.SignUpResponse;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaveAuthService {

    private final MemberRepository memberRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public SignUpResponse save(SignUpRequest request) {
        memberRepository.findByEmail(request.getEmail())
                .ifPresent(member -> {
                    throw new IllegalArgumentException(signUpErrorMessage(member));
                });

        Member member = request.toEntity();
        memberRepository.save(member);

        return request.toResponse(member);
    }

    public SignInResponse signIn(SignInRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일 입니다."));

        checkPassword(request.getPassword(), member.getPassword());

        if (member.getStatus() != MemberStatus.APPROVED) {
            throw new IllegalArgumentException(signInErrorMessage(member));
        }

        String accessToken = jwtTokenUtil.generateAccessToken(member);
        String refreshToken = jwtTokenUtil.generateRefreshToken(member);

        jwtTokenUtil.isValidToken(accessToken);

        return SignInResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private String signUpErrorMessage(Member member) {
        return switch (member.getStatus()) {
            case PENDING -> "가입 승인 처리 중 입니다.";
            case APPROVED -> "이미 가입된 이메일 입니다.";
            case REJECTED -> "가입 승인이 거절되었습니다.";
            case DELETED -> "탈퇴 처리된 회원입니다.";
        };
    }

    private void checkPassword(String password, String hashedPassword) {
        if (!BcryptUtil.isMatch(password, hashedPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    private String signInErrorMessage(Member member) {
        return switch (member.getStatus()) {
            case PENDING -> "가입 승인 처리 중 입니다.";
            case REJECTED -> "가입 승인이 거절되었습니다.";
            case DELETED -> "탈퇴 처리된 회원입니다.";
            default -> null;
        };
    }
}
