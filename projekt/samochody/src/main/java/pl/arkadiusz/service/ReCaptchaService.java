package pl.arkadiusz.service;

public interface ReCaptchaService {
    boolean verify(String captcha);
}
