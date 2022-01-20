package sluu.sodapop.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import sluu.sodapop.entity.SodaPack;

public class CSVHelper {
  
  public static ByteArrayInputStream sodaPacksToCSV(List<SodaPack> sodaPacks) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
        List<String> headers = Arrays.asList("uuid", "name", "weight", "count", "isFragile", "bottlingType", "unitsPerPack", "volumePerUnit");
        csvPrinter.printRecord(headers);
      for (SodaPack sodaPack : sodaPacks) {
        List<String> data = Arrays.asList(
              sodaPack.getUuid().toString(),
              sodaPack.getName(),
              sodaPack.getWeight().toString(),
              String.valueOf(sodaPack.getCount()),
              String.valueOf(sodaPack.isFragile()),
              sodaPack.getBottlingType().toString(),
              String.valueOf(sodaPack.getUnitsPerPack()),
              String.valueOf(sodaPack.getVolumePerUnit())
            );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }
}
