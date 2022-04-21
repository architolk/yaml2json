package nl.architolk.yaml2json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Convert {

  private static final Logger LOG = LoggerFactory.getLogger(Convert.class);


  public static void main(String[] args) {

    LOG.info("Start");

    try {
      ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
      Object obj = yamlReader.readValue(new File(args[0]), Object.class);

      ObjectMapper jsonWriter = new ObjectMapper();
      jsonWriter.writeValue(new File(args[1]), obj);
    }
    catch (Exception e) {
      LOG.info(e.getMessage());
    }

  }

}
