package irusev.exportjson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class StartExporting 
{
    public static void main( String[] args ) throws JsonGenerationException, IOException, ClassNotFoundException 
    {
    	String fullyQualifiedClassPAth = args.length > 0 ? args[0] : "irusev.exportjson.TestObjB";
    	Class<?> clazz = Class.forName(fullyQualifiedClassPAth);
    	String classJsonRepresentation = getJsonSchema(clazz);
    	System.out.println(classJsonRepresentation);
    }
    
    private static String getJsonSchema(@SuppressWarnings("rawtypes") Class clazz) throws IOException {
    	ObjectMapper om = new ObjectMapper();
    	 JsonSchemaGenerator generator = new JsonSchemaGenerator(om);
    	   JsonSchema jsonSchema = generator.generateSchema(clazz);

        return om.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema);
    }
}
