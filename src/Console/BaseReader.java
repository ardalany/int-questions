/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

/**
 *
 * @author Ardalan
 */
public abstract class BaseReader<T> {
    protected final OneLineReader _reader;
    protected final OneLineWriter _writer;
    private final Class<T> _classType;
    
    public BaseReader(Class<T> classType){
        _reader = new OneLineReader();
        _writer = new OneLineWriter();
        _classType = classType;
    }
    
    protected T parse(String stringValue) throws Exception{
        return _classType.getConstructor(new Class[] {String.class }).newInstance(stringValue);
    }
}
