package dojo.getindex;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class GetIndex {

  public int getIndex(int[] values, int value) {
    if (values.length == 0) {
      return -2;
    } else {
      for (int i = 0; i < values.length; i++) {
        if (values[i] == value) {
          return i;
        }
      }
      return -1;
    }
  }
}