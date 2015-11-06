package decode;

import java.io.File;

import data.Data;
import data.Transaction;

public class IngToTransactions extends CSVToTransactions {

	public IngToTransactions(Data data, File file) {
		super(data, file);
	}


	@Override
	Transaction readFromLine(String inLine, int number) {
		// TODO Auto-generated method stub
		return null;
	}

}
