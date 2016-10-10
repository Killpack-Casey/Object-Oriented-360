import org.quickconnectfamily.json.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Casey on 10/9/2016.
 */
public class myQcjson implements Serializable {

//qcjson another way to manipulate json data to java
    String firstName = "Object-Santa";
    String lastName = "Object-Claus";
    int age = 0;

    public myQcjson(int a){

        this.age = a;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //create an object of the myQcjson class
        myQcjson obj = new myQcjson(25);
        System.out.println("Print out contents of the obj object");
        System.out.println(obj.firstName + " " + obj.lastName + " " + obj.age);
        System.out.println("------------------------------------------------------------------");

        //create another object
        myQcjson object = new myQcjson(50);

        //happy path: create an arrayList to store two objects
        ArrayList myArray = new ArrayList();
        myArray.add(0, obj);
        myArray.add(1, object);

        //jsoninputstream reads file
        //jsonoutpstream reads or writes out to file
        //nasty path trying to read or write to files you have no permission to
        //nasty path reading an image file
        //nasty path trying to read a file with nothing in it null file

        //create file for my valid json
        File file = new File("QCJSON_Valid.txt");

        //create file for my invalid json
        File badFile = new File("QCJSON_InValid.txt");

        //creates file stream
        try {
            //using the FileOutputStream we create a stream for our valid json
            FileOutputStream fileOut = new FileOutputStream(file);

            //using the FileOutputStream we create a stream for our invalid json
            FileOutputStream badFileOut = new FileOutputStream(badFile);

            //nasty path: PrintWriter does not work with a file created from the FileOutputStream
            PrintWriter writer = new PrintWriter(file);

            //nasty path: This will write nothing to the file
            writer.print(object);
            //nasty path: This will write nothing to the file
            writer.print(obj);

            //happy path: this is similar to creating a printWriter, but is used when creating a file
            //from the FileOutputStream class
            JSONOutputStream jsonOut = new JSONOutputStream(fileOut);
            //for the invalid json
            JSONOutputStream badJsonOut = new JSONOutputStream(badFileOut);

            try {
                //nasty path: invalid json
                //prints object to file in json
                badJsonOut.writeObject(obj);
                //prints another object to file in json
                badJsonOut.writeObject(object);

                //happy path: The two objects need to be nested in an array and can't be wrote seperately to a file,
                //like the above nasty path example otherwise it is not valid json and you will have a hard time reading
                // in the JSON data
                jsonOut.writeObject(myArray);
                //close the file write
                jsonOut.close();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read json file into java
        try {
            //Create file input streams
            FileInputStream read = new FileInputStream(file);
            FileInputStream badRead = new FileInputStream(badFile);

            //create JSONInputStreams
            JSONInputStream readIn = new JSONInputStream(read);
            JSONInputStream badReadIn = new JSONInputStream(badRead);

            //happy path: create array list to read in JSON array
            ArrayList contain = new ArrayList();
            contain = (ArrayList) readIn.readObject();

            //nasty path: you can not access the key value pairs if you stick the JSON Object in an object
            Object containObject = contain.get(1);
            containObject = contain.get(1);
            //nasty path
            System.out.println("Nasty Path");
            System.out.println("Prints the contents of the object after assigning the second object of the array " +
                    "in index 1 to it ");
            System.out.println(containObject.toString());
            System.out.println("-----------------------------------------------------------------");

            //nasty path: won't cast to myQcjson object
            //myQcjson containObj = new myQcjson(0);
            //containObj = (myQcjson) contain.get(0);

            //nasty path: You will get an error saying cannot cast to HashMap
            //System.out.println("Grabs index 0 in JSONARRAY " + containObj.firstName);

            System.out.println("Reading out obj in Java from JSON");
            //happy path: read obj from the file
            //you want to put your json objects in a hash map because the JSONObject has key value pairs
            HashMap map = (HashMap) contain.get(0);
            //nasty path: You cannot use int throws an error
            //int age = (int) map.get("age");
            long age = (long) map.get("age");
            String first = (String) map.get("firstName");
            String last = (String) map.get("lastName");
            System.out.println("obj-firstName: " + first);
            System.out.println("obj-lastName: " + last);
            System.out.println("obj-age: " + age);
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Reading out Object in Java from JSON");
            //happy path: read object from the file
            HashMap map2 = (HashMap) contain.get(1);
            //nasty path: You cannot use int throws an error
            //int age2 = (int) map2.get("age");
            long age2 = (long) map2.get("age");
            String first2 = (String) map2.get("firstName");
            String last2 = (String) map2.get("lastName");
            System.out.println("object-firstName: " + first2);
            System.out.println("object-lastName: " + last2);
            System.out.println("object-age: " + age2);
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Convert obj back to json using the stringify method");
            //stringify method converts an object back to json. It's very helpful because instead of using the string builder
            //you can use stringify to build your strings
            String combine = JSONUtilities.stringify((Serializable) contain.get(0));
            System.out.println(combine);
            //not json
            System.out.println(contain.get(0));

            readIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

