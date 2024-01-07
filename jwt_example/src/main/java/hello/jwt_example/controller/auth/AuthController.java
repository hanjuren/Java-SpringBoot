package hello.jwt_example.controller.auth;

import hello.jwt_example.service.auth.SaveAuthService;
import hello.jwt_example.service.auth.dto.SignInRequest;
import hello.jwt_example.service.auth.dto.SignInResponse;
import hello.jwt_example.service.auth.dto.SignUpRequest;
import hello.jwt_example.service.auth.dto.SignUpResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final SaveAuthService saveAuthService;

    @PostMapping("sign-up")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody @Valid SignUpRequest request) {
        SignUpResponse result = saveAuthService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponse> signIn(@RequestBody @Valid SignInRequest request) {
        SignInResponse result = saveAuthService.signIn(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
