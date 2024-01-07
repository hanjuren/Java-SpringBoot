package hello.jwt_example.service.auth.dto;

import hello.jwt_example.common.util.BcryptUtil;
import hello.jwt_example.domain.member.Member;
import hello.jwt_example.domain.member.MemberRole;
import hello.jwt_example.domain.member.MemberStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignUpRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    private MemberRole role;

    public Member toEntity() {
        MemberRole role = this.role == null ? MemberRole.USER : this.role;

        return Member.builder()
                .email(email)
                .password(BcryptUtil.encrypt(password))
                .name(name)
                .role(role)
                .status(MemberStatus.PENDING)
                .build();
    }

    public SignUpResponse toResponse(Member member) {
        return SignUpResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .role(member.getRole())
                .status(member.getStatus())
                .role(member.getRole())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .build();
    }
}
