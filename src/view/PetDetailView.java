package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import dto.PetDTO;
import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.pet_bio.PetBioState;
import interface_adapter.pet_bio.PetBioViewModel;

public class PetDetailView extends JPanel implements PropertyChangeListener {
 	private static final long serialVersionUID = 1L;
	public static final String viewName = "Pet Bio";
	private DisplayPetsController displayPetsController;

	public PetDetailView(PetBioViewModel petDetailViewModel, DisplayPetsController displayPetsController) {
        initComponents();
        this.displayPetsController = displayPetsController;
        petDetailViewModel.addPropertyChangeListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        breedText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ageText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        petIDText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        speciesesText = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        jLabel1.setText("Name:");

        nameText.setEditable(false);

        jLabel2.setText("Breed:");

        breedText.setEditable(false);

        jLabel3.setText("Age:");

        ageText.setEditable(false);

        jLabel4.setText("Pet ID");

        petIDText.setEditable(false);

        jLabel5.setText("Species");

        speciesesText.setEditable(false);

        backButton.setText("<Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameText)
                            .addComponent(breedText)
                            .addComponent(ageText)
                            .addComponent(petIDText)
                            .addComponent(speciesesText, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(breedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(petIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(speciesesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	displayPetsController.execute(viewUser);
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JTextField ageText;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField breedText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField petIDText;
    private javax.swing.JTextField speciesesText;
	private String viewUser;

    @Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getNewValue() instanceof PetBioState) {
			PetBioState state = (PetBioState) evt.getNewValue();
			this.viewUser = state.getViewUser();
            PetDTO pet = state.getPet();
			nameText.setText(pet.getName());
			petIDText.setText("" + pet.getPetID());
			breedText.setText(pet.getBreed());
			ageText.setText("" + pet.getPetAge());
			speciesesText.setText(pet.getSpecies());
		}
	}

}
