public class IllegalNumberException extends Exception {

  private String message;  //エラーメッセージ

  IllegalNumberException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
