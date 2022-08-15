package test.doubles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserServiceMockTest {
    @Mock()
    IUserRepository userRepository;

    @BeforeEach
    void setUp () {
        Mockito.mockitoSession()
                .initMocks(this)
                .strictness(Strictness.STRICT_STUBS)
                .startMocking();
    }

    @Test
    void should_checkIdIsReturnedIsCalled() {
        // ARRANGE
        var service = new CreateUserService(userRepository, new UserValidationService(), null);
        Mockito.when(userRepository.insert("John Doe", "john@doe.fr")).thenReturn("123");

        // ACT
        var result = service.createUser("John Doe", "john@doe.fr");

        // ASSERT
        assertEquals("123", result);
        Mockito.verify(userRepository);
    }

    @Test
    void should_failIfMockIsBadlySetup() {
        // ARRANGE
        var service = new CreateUserService(userRepository, new UserValidationService(), null);
        Mockito.when(userRepository.insert("Kermit", "kermit@thefrog.fr")).thenReturn("123");

        // ACT
        var result = service.createUser("John Doe", "john@doe.fr");

        // ASSERT
        assertEquals("123", result);
    }
}
