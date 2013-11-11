package oleksii.filonov.googleanalytics.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import oleksii.filonov.googleanalytics.domainmodel.Product;

import org.springframework.stereotype.Component;

import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

@Component
public class ProductReader {

	public List<Product> readProductsFromFile(final String pathToFile) throws IOException {

		final Reader reader = new InputStreamReader(getClass().getResourceAsStream(pathToFile));

		final ValueProcessorProvider provider = new ValueProcessorProvider();
		final CSVEntryParser<Product> entryParser = new AnnotationEntryParser<Product>(Product.class, provider);
		final CSVReader<Product> csvPersonReader = new CSVReaderBuilder<Product>(reader).entryParser(entryParser).build();

		return csvPersonReader.readAll();

		//final BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(pathToFile)));

	}

}
