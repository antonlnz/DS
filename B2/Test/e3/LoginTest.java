package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    LoginScreen emailLoginScreen = new LoginScreen();
    LoginScreen telephoneLoginScreen = new LoginScreen();
    LoginScreen dniLoginScreen = new LoginScreen();
    LoginScreen otherLoginScreen = new LoginScreen();
    LoginDNI otherLoginDNI = new LoginDNI(otherLoginScreen.users);
    LoginTelephone otherLoginTelephone = new LoginTelephone(otherLoginScreen.users);
    User anton = new User("anton.lopez.nunez@udc.es", "9876");
    User carlos = new User("carlos.martinez4@udc.es", "1234");
    User tlf1 = new User("666777888", "1111");
    User invalidTlf = new User("01234-56789", "2222");
    User dni1 = new User("00000023T", "9999");
    User invalidDNI = new User ("00000023R", "8888"); //The letter is not the right letter
    User dni2 = new User("00000001R", "7777");

    @Test
    void LoginEmailtest(){
        System.out.println("LOGIN EMAIL TEST");
        emailLoginScreen.signIn(anton);
        emailLoginScreen.signIn(anton);//Repeated email.
        emailLoginScreen.signIn(carlos);
        emailLoginScreen.signIn("1234","5678");//Invalid email
        assertTrue(emailLoginScreen.loginStrategy.validateId(anton.id));
        assertTrue(emailLoginScreen.loginStrategy.validateId(carlos.id));
        assertFalse(emailLoginScreen.loginStrategy.authenticatePassword("1234", "5678"));
        assertTrue(emailLoginScreen.loginStrategy.authenticatePassword(carlos.id, carlos.password));
        assertFalse(emailLoginScreen.loginStrategy.authenticatePassword(carlos.id, anton.password));
    }
    @Test
    void LoginTelephoneTest(){
        System.out.println("LOGIN TELEPHONE TEST");
        LoginTelephone loginTelephone = new LoginTelephone(telephoneLoginScreen.users);
        telephoneLoginScreen.setLogin(loginTelephone);
        telephoneLoginScreen.signIn(tlf1);
        telephoneLoginScreen.signIn(tlf1);// Repeated telephone.
        telephoneLoginScreen.signIn(invalidTlf);//Invalid telephone
        assertTrue(telephoneLoginScreen.loginStrategy.authenticatePassword(tlf1.id, tlf1.password));
        assertFalse(telephoneLoginScreen.loginStrategy.authenticatePassword(invalidTlf.id, invalidTlf.password));
    }
    @Test
    void LoginDniTest(){
        System.out.println("LOGIN DNI TEST");
        LoginDNI loginDNI = new LoginDNI(dniLoginScreen.users);
        dniLoginScreen.setLogin(loginDNI);
        dniLoginScreen.signIn(dni1);
        dniLoginScreen.signIn(dni1);//Repeated dni.
        dniLoginScreen.signIn(invalidDNI);
        dniLoginScreen.signIn(dni2);

        assertTrue(dniLoginScreen.loginStrategy.authenticatePassword(dni1.id, dni1.password));
        assertTrue(dniLoginScreen.loginStrategy.authenticatePassword(dni2.id, dni2.password));

    }
    @Test
    void LoginMixedtest(){
        System.out.println("LOGIN MIXED TEST");
        otherLoginScreen.signIn(anton);
        otherLoginScreen.signIn(carlos);

        otherLoginScreen.setLogin(otherLoginTelephone);

        otherLoginScreen.signIn("666666666", "hola");
        otherLoginScreen.signIn("777777777", "adios");

        otherLoginScreen.setLogin(otherLoginDNI);

        otherLoginScreen.signIn("23000000T", "bogavante");
        otherLoginScreen.signIn("23000001R", "centollo");
        otherLoginScreen.signIn("23000002W", "langostino");

        assertTrue(otherLoginScreen.loginStrategy.authenticatePassword("23000002W", "langostino"));
        assertTrue(otherLoginScreen.loginStrategy.authenticatePassword("666666666", "hola"));
    }
}