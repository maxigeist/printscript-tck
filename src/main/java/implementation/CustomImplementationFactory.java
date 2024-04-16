package implementation;

import interpreter.ErrorHandler;
import interpreter.InputProvider;
import interpreter.PrintEmitter;
import interpreter.PrintScriptInterpreter;


import app.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class CustomImplementationFactory implements InterpreterFactory {

    @Override
    public PrintScriptInterpreter interpreter() {
        // your PrintScript implementation should be returned here.
        // make sure to ADAPT your implementation to PrintScriptInterpreter interface.
        return (src, version, emitter, handler, provider) -> {
            Exec exe = new Exec();
            exe.execute(makeFile(src), parseVersion(version));
        };
        // Dummy impl: return (src, version, emitter, handler) -> { };
    }

    public String parseVersion(String version){
        return "v1";
    }


    public String makeFile(InputStream mockup) throws IOException {
        FileWriter file = new FileWriter("src/main/java/implementation/file.interpreter.txt");
        file.write(mockup.readAllBytes().toString());
        file.close();
        return "src/main/java/implementation/file.interpreter.txt";
    }

}