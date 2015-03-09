package info.ccserver.homunculus.engine.lua;

import info.ccserver.homunculus.engine.IEngine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.luaj.vm2.LuaError;

public class LuaEngine implements IEngine {

	public LuaEngine() {
		engine = new ScriptEngineManager().getEngineByName("luaj");
	}

	private static ScriptEngine engine;

	@Override
	public Object eval(String script) {
		// TODO 自動生成されたメソッド・スタブ
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
