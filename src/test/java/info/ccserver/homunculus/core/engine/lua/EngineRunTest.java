package info.ccserver.homunculus.core.engine.lua;

import info.ccserver.homunculus.core.engine.IEngine;

import javax.script.ScriptException;

import org.junit.Assert;
import org.junit.Test;

public class EngineRunTest {
	@Test
	public void create() throws ScriptException {
		IEngine luaEngine = new LuaEngine();
		String script = "return coroutine.wrap(function() " + "\n"
				+ "coroutine.yield(\"string\")" + "\n" + "end)()";
		Assert.assertNotNull(luaEngine);
		Object ret = luaEngine.eval(script);
		System.out.println(ret);
		Assert.assertEquals("string", ret);

	}

	@Test
	public void cannotAccessOS() throws ScriptException {
		IEngine luaEngine = new LuaEngine();

		String script = "return os";
		Object ret = luaEngine.eval(script);
		System.out.println(ret);
		Assert.assertNull(ret);
	}
}
