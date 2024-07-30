import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class PetAdoptionUI extends JFrame {

    public PetAdoptionUI(List<Pet> pets) {
        setTitle("Pet Adoption Platform");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridBagLayout to center the content
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Create a smaller panel to hold the pet panels
        JPanel petListPanel = new JPanel();
        petListPanel.setLayout(new BoxLayout(petListPanel, BoxLayout.Y_AXIS));

        for (Pet pet : pets) {
            petListPanel.add(createPetPanel(pet));
        }

        // Add the pet list panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(petListPanel);
        scrollPane.setPreferredSize(new Dimension(400, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Add the scroll pane to the frame
        add(scrollPane, gbc);

        setVisible(true);
    }

    private JPanel createPetPanel(Pet pet) {
        JPanel petPanel = new JPanel();
        petPanel.setLayout(new FlowLayout());

        JButton nameButton = new JButton("Name: " + pet.getName());
        nameButton.setBorderPainted(false);
        nameButton.setContentAreaFilled(false);
        nameButton.setFocusPainted(false);
        nameButton.setForeground(Color.BLUE);
        nameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show pet details in a popup
                JOptionPane.showMessageDialog(null, "Pet Details:\nName: " + pet.getName() + "\nBreed: " + pet.getBreed());
            }
        });

        JLabel breedLabel = new JLabel("Breed: " + pet.getBreed());

        JButton adoptButton = new JButton("Adopt");
        adoptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call adopt use case
                adoptPet(pet);
            }
        });

        JButton bookmarkButton = new JButton("Add Bookmark");
        bookmarkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call add bookmark use case
                addBookmark(pet);
            }
        });

        petPanel.add(nameButton);
        petPanel.add(breedLabel);
        petPanel.add(adoptButton);
        petPanel.add(bookmarkButton);

        return petPanel;
    }

    private void adoptPet(Pet pet) {
        // Implement the adopt use case
        System.out.println("Adopting pet: " + pet.getName());
    }

    private void addBookmark(Pet pet) {
        // Implement the add bookmark use case
        System.out.println("Bookmarking pet: " + pet.getName());
    }

    public static void main(String[] args) {
        // Example pets list
        List<Pet> pets = Arrays.asList(
                new Pet("Bella", "German Shepherd"),
                new Pet("Max", "Labrador Retriever"),
                new Pet("Luna", "Siamese Cat"),
                new Pet("Charlie", "Bulldog"),
                new Pet("Lucy", "Poodle"),
                new Pet("Daisy", "Beagle"),
                new Pet("Bailey", "Golden Retriever"),
                new Pet("Molly", "French Bulldog"),
                new Pet("Coco", "Shih Tzu"),
                new Pet("Rocky", "Rottweiler"),
                new Pet("Lola", "Dachshund"),
                new Pet("Buddy", "Pomeranian"),
                new Pet("Shadow", "Doberman"),
                new Pet("Milo", "Cocker Spaniel"),
                new Pet("Simba", "Bengal Cat")
        );
        new PetAdoptionUI(pets);
    }
}

class Pet {
    private String name;
    private String breed;

    public Pet(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }
}
