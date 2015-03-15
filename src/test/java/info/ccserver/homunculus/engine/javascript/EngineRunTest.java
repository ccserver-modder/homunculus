package info.ccserver.homunculus.engine.javascript;

import info.ccserver.homunculus.core.engine.IEngine;
import info.ccserver.homunculus.core.engine.javascript.JavaScriptEngine;

import javax.script.ScriptException;

import org.junit.Assert;
import org.junit.Test;

public class EngineRunTest {
	@Test
	public void create() throws ScriptException {
		IEngine jsEngine = new JavaScriptEngine();
		String script = /* "version(170);" + "\n" + */"new function () {"
				+ "\n" + "yield \"string\";" + "\n" + "}().next();";
		Assert.assertNotNull(jsEngine);
		Object ret = jsEngine.eval(script);
		Assert.assertEquals("string", ret);

	}
}
