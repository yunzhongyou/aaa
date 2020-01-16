package novel.storage;

import java.io.FileNotFoundException;

import novel.storage.impl.BxwxNovelStorageImpl;

public class Storage {

	public static void main(String[] args) throws FileNotFoundException {
		/*if(args.length==0)
			System.exit(0);*/
		System.out.println("storage yunxingle");
		String result ="https://www.bxwx9.org/b/190/190490/index.html";
		result = result.replace("index.html", "");
		System.out.println(result);
		
		
		Processor processor = new BxwxNovelStorageImpl();
		processor.process();
		
		
		
	}
}
