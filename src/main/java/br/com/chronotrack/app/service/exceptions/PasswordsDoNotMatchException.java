package br.com.chronotrack.app.service.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{

  public PasswordsDoNotMatchException(String message){
    super(message);
  }
}
