package project01.sniffPro.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project01.sniffPro.domain.User;
import project01.sniffPro.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    @Transactional
    public Long join(User user) {
        //중복 체크
        validateDuplicateUser(user);
        
        userRepository.save(user);
        return user.getId();
    }

    //중복 확인 로직
    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByName(user.getName());
        if(!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    //전체 회원 조회
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //회원 조회
    public User findUser(Long userId) {
        return userRepository.findOne(userId);
    }

}
