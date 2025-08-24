package br.com.chronotrack.app.service.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{

  public ResourceAlreadyExistsException(String message){
    super(message);
  }
}
