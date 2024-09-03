import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Class GenerateInfoFiles
 * 
 * This class is responsible for generating test files containing information
 * about salesmen, products, and sales. The generated files will be used as
 * input in the next phase of the project to process the data.
 */
public class GenerateInfoFiles {

    /**
     * Method to generate a file with salesman information.
     * 
     * @param salesmanCount The number of salesmen to generate.
     * 
     * The generated file will be named "vendedores.txt" and will contain the
     * following information for each salesman:
     * DocumentType;DocumentNumber;FirstName;LastName
     */
    public static void createSalesManInfoFile(int salesmanCount) {
        String[] firstNames = {"Juan", "Maria", "Carlos", "Ana", "Luis", "Sofia", "Fernando", "Laura"};
        String[] lastNames = {"Perez", "Garcia", "Rodriguez", "Lopez", "Martinez", "Hernandez", "Gomez", "Diaz"};

        try (FileWriter fileWriter = new FileWriter("vendedores.txt")) {
            Random rand = new Random();

            for (int i = 0; i < salesmanCount; i++) {
                String documentType = "CC";
                long documentNumber = 1000000000L + rand.nextInt(900000000);
                String firstName = firstNames[rand.nextInt(firstNames.length)];
                String lastName = lastNames[rand.nextInt(lastNames.length)];

                fileWriter.write(documentType + ";" + documentNumber + ";" + firstName + ";" + lastName + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to generate a file with product information.
     * 
     * @param productsCount The number of products to generate.
     * 
     * The generated file will be named "productos.txt" and will contain the
     * following information for each product:
     * ProductID;ProductName;UnitPrice
     */
    public static void createProductsFile(int productsCount) {
        String[] productNames = {"ProductA", "ProductB", "ProductC", "ProductD", "ProductE", "ProductF"};
        double[] prices = {20.50, 15.00, 10.00, 5.50, 7.75, 12.30};

        try (FileWriter fileWriter = new FileWriter("productos.txt")) {
            Random rand = new Random();

            for (int i = 0; i < productsCount; i++) {
                String productID = "ID" + (i + 1);
                String productName = productNames[rand.nextInt(productNames.length)];
                double price = prices[rand.nextInt(prices.length)];

                fileWriter.write(productID + ";" + productName + ";" + price + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to generate a sales file for a specific salesman.
     * 
     * @param randomSalesCount The number of random sales to generate.
     * @param name             The name of the salesman.
     * @param id               The document number of the salesman.
     * 
     * The generated file will be named "vendedor_<id>.txt" and will contain the
     * following information for each sale:
     * ProductID;QuantitySold;
     */
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        try (FileWriter fileWriter = new FileWriter("vendedor_" + id + ".txt")) {
            fileWriter.write("CC;" + id + "\n");
            Random rand = new Random();

            for (int i = 0; i < randomSalesCount; i++) {
                String productID = "ID" + (rand.nextInt(10) + 1);
                int quantitySold = rand.nextInt(10) + 1;

                fileWriter.write(productID + ";" + quantitySold + ";\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method to test file generation.
     * 
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Generate a salesman information file with 5 salesmen
        createSalesManInfoFile(5);
        System.out.println("Salesman information file generated successfully.");

        // Generate a product information file with 5 products
        createProductsFile(5);
        System.out.println("Product information file generated successfully.");

        // Generate a sales file for a specific salesman
        createSalesMenFile(10, "Juan Perez", 1234567890L);
        System.out.println("Sales file for salesman Juan Perez generated successfully.");

        System.out.println("All files have been generated successfully.");
    }
}
