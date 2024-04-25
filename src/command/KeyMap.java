package command;

import java.util.*;

public class KeyMap {

  private Map<String,Command> map=new HashMap<String,Command>();

  public Command get(char c) {
    return map.get(c + "");
  }

  public void put(char c, Command command) {
    map.put(c+"",command);
  }
  public void putCtrl(char c, Command command) {
    map.put(controlConvert(c)+"",command);
  }
  private char controlConvert(char c){
    return (char)(c&'\u001f');
  }

}
