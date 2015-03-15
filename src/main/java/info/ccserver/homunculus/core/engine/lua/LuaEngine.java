package info.ccserver.homunculus.core.engine.lua;

import info.ccserver.homunculus.core.engine.IEngine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;

public class LuaEngine implements IEngine {

	private LuaValue chunk;
	private Globals globals;

	public LuaEngine() throws ScriptException {
		engine = new ScriptEngineManager().getEngineByName("luaj");
		engine.eval("rawset(_ENV, \"os\", nil)");
		engine.eval("rawset(_ENV, \"io\", nil)");
	}

	private static ScriptEngine engine;

	@Override
	public Object eval(String script) {
		try {
			return engine.eval(script);

		} catch (ScriptException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (LuaError e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
