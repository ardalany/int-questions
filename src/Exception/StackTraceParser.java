/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.io.*;

/**
 *
 * @author Ardalan
 */
public class StackTraceParser {
    /*
    http://stackoverflow.com/questions/18546842/stack-trace-as-string
    */
    public String getStackTrace(final Throwable throwable) {
     final StringWriter sw = new StringWriter();
     final PrintWriter pw = new PrintWriter(sw, true);
     throwable.printStackTrace(pw);
     return sw.getBuffer().toString();
}
}
