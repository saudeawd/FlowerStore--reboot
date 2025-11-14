package flower.store.controller;

import flower.store.AppUser;
import flower.store.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody AppUser user) {
        Optional<AppUser> existingUser = appUserRepository.findUserByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("User with this email already exists");
        }
        if (user.getDob() != null && user.getDob().isAfter(LocalDate.now())) {
            return ResponseEntity.badRequest().body("Date of birth cannot be in the future");
        }

        AppUser savedUser = appUserRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
