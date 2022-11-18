package nizekAccountant.logic.UserRepository;

import nizekAccountant.logic.AdminModel.Admin;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.Login.Costumer;

import java.io.File;
import java.util.List;

public interface Storeable {

    // Read Implementations!
    String readFile(CheckDoc normalDoc, int id);
    String readFile(NormalDoc normalDoc, int id);
    String readFile(Costumer normalDoc, String inputNationalID);
    String readAdmin(Admin admin);

    // Write Implementations!
   void writerToFile(Costumer costumer);
   void writeToFile(NormalDoc normalDoc);
   void writeToFile(CheckDoc checkDoc);
   void writeToFile(Admin admin);

   // Read ALL IMPLEMENTATION
   List<String> readWholeFile(File file);


}
