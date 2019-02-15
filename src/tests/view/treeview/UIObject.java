package tests.view.treeview;

import java.util.HashMap;

public class UIObject {
	public HashMap<String,Object> data = new HashMap<String, Object>();
	public String name;

	public UIObject(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getData(String key) {
		return data.get(key);
	}

	public void setData(String key, Object value) {
		data.put(key, value);
	}
}
