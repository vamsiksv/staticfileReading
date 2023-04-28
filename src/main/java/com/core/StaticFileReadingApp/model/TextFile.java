package com.core.StaticFileReadingApp.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class TextFile implements Externalizable {
	
	
	private long lastModified;
	
	private String content;
	

	public TextFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getLastModified() {
		return lastModified;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeLong(lastModified);
		out.writeUTF(content);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

		lastModified = in.readLong();
		content = in.readUTF();
	}

}
