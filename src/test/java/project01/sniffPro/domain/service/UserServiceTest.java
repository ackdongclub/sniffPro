package project01.sniffPro.domain.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project01.sniffPro.domain.User;
import project01.sniffPro.repository.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception{
        //given
        User user = new User();
        user.setName("kim");

        //when
        Long saveId = userService.join(user);

        //then
        assertEquals(user, userRepository.findOne(saveId));
     }

     @Test
     public void 중복_이름_확인() throws Exception{
         //given
         User user1 = new User();
         user1.setName("kim");

         User user2 = new User();
         user2.setName("kim");

         //when
         userService.join(user1);

         //then
         IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));
         assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

      }

}