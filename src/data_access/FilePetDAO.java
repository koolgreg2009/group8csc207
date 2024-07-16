package data_access;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Pet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilePetDAO {
    private final File jsonFile;

    private final Map<Integer, Pet> pets = new HashMap<Integer, Pet>();

    public FilePetDAO(String jsonPath) throws IOException {
        jsonFile = new File(jsonPath);
        if (jsonFile.length() == 0) {
            save();
        } else {
            TypeReference<HashMap<Integer, Pet>> typeRef = new TypeReference<HashMap<Integer, Pet>>() {
            };
            ObjectMapper objectMapper = new ObjectMapper();
            pets.putAll(objectMapper.readValue(jsonFile, typeRef));
        }
    }
    public void save(Pet pet) {
        pets.put(pet.getPetID(), pet); // apparently this autoboxes
        this.save();
    }

    public Pet get(int petID) {
        return pets.get(petID);
    }

    private void save() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(jsonFile, pets);
        } catch (Exception ex) {
            System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

//    @Override
//    public boolean existsByName(String identifier) {
//        return pets.containsKey(identifier);
//    }


}
