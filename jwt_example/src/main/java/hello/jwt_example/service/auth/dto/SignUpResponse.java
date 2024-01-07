package hello.jwt_example.service.auth.dto;

import hello.jwt_example.domain.member.MemberRole;
import hello.jwt_example.domain.member.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SignUpResponse {

    private Long id;
    private String email;
    private String name;
    private MemberRole role;
    private MemberStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
