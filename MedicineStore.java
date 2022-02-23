package com.medicineStore.bl;

	import java.util.ArrayList;
	import java.util.*;

class Medicine {

	    enum MedicineType {
	        AYURVEDIC, ALLOPATHIC, HOMEOPATHIC;
	    }

	    String name;
	    String brandName;
	    double prize;
	    MedicineType type;

	    Medicine() {

	    }

	    Medicine(String name1, String brandName1, double prize1, MedicineType type1) {
	        name = name1;
	        brandName = brandName1;
	        prize = prize1;
	        type = type1;

	    }

	    public void display() {
	        System.out.println("Name:" + name + "\nBrandName: " + brandName + "\nPrize:" + prize + "\n" + "type:" + type);
	    }

	    public void displayMedicineTypes() {
	        System.out.println(
	                "1." + MedicineType.AYURVEDIC + "\n2." + MedicineType.ALLOPATHIC + "\n3." + MedicineType.HOMEOPATHIC);
	    }
	}

	class Paracetmol extends Medicine {

	    Paracetmol() {
	        name = "Paracetmol";
	        brandName = "Dr.Reddy's";
	        type = MedicineType.ALLOPATHIC;
	    }
	}

	class MedicalStoreCrud {
	    ArrayList<Medicine> medicineList = new ArrayList<Medicine>();

	    public void displayAllMedicine() {
	        if (medicineList.size() > 0) {
	            for (int i = 0; i < medicineList.size(); i++) {
	                Medicine m1 = medicineList.get(i);
	                m1.display();
	            }
	        } else {
	            System.out.println("No Medicines Available");
	        }
	        //
	    }

	    public void addMedicine(Medicine m2) {
	        medicineList.add(m2);
	        System.out.println("Medicine Added Successfully");
	    }

	    public void searchMedicine(String medicineName) {
	        if (medicineList.size() > 0) {
	            for (int i = 0; i < medicineList.size(); i++) {
	                Medicine m1 = medicineList.get(i);
	                if (m1.name.equalsIgnoreCase(medicineName)) {
	                    System.out.println("Medicine Found:");
	                    m1.display();
	                    break;
	                }
	                if (i < medicineList.size()) {
	                    System.out.println("Medicine Not Found.");
	                }
	            }
	        } else {
	            System.out.println("No Medicine Available");
	        }
	    }

	    public void updateMedicine(String medicineNameForUpdate) {
	        Scanner s1 = new Scanner(System.in);
	        System.out.println("Enter Medicine Name to update:");
	        String nameToUpdate = s1.nextLine();
	        System.out.println("Enter Medicine Brand Name to update:");
	        String brandNameToUpdate = s1.nextLine();
	        System.out.println("Enter Medicine Prize to update:");
	        double prizeToUpdate = s1.nextDouble();
	        int flag = 0;
	        for (Medicine medicine : medicineList) {
	            if (medicine.name.equalsIgnoreCase(medicineNameForUpdate)) {
	                medicine.name = nameToUpdate;
	                medicine.brandName = brandNameToUpdate;
	                medicine.prize = prizeToUpdate;
	                System.out.println("Medicine Updated Successfully");
	                break;
	            } else {
	                flag = 1;
	            }
	        }
	        if (flag == 1) {
	            System.out.println("Medicine Not Found.");
	        }
	    }

	    public void deleteMedicine() {
	        Scanner s2 = new Scanner(System.in);
	        System.out.println("Enter Medicine name to delete:");
	        String nameToDelete = s2.nextLine();
	        int flag = 0;
	        for (Medicine medicine : medicineList) {
	            if (medicine.name.equalsIgnoreCase(nameToDelete)) {
	                medicineList.remove(medicine);
	                System.out.println("Medicine Deleted Successfully");
	                break;
	            } else {
	                flag = 1;
	            }
	        }
	        if (flag == 1) {
	            System.out.println("Medicine Not Found.");
	        }
	    }
	}

	public class MedicineStore {
	    public static void main(String ar[]) {
	        MedicalStoreCrud msc = new MedicalStoreCrud();
	        Paracetmol p1 = new Paracetmol();
	        p1.prize = 101;
	        msc.medicineList.add(p1);
	        Scanner s1 = new Scanner(System.in);
	        int ch;
	        do {
	            System.out.println("1.Add \n 2.display \n 3. Search \n 4.Update Medicine\n 5.Delete Medicine\n 6.Exit");
	            System.out.println("Enter a choice:");
	            ch = s1.nextInt();
	            switch (ch) {
	                case 1:
	                    Scanner s2 = new Scanner(System.in);
	                    System.out.println("Enter Medicine Name:");
	                    String name = s2.nextLine();
	                    System.out.println("Enter Medicine brandName:");
	                    String brnadName = s2.nextLine();
	                    System.out.println("Select Medicine Type:");
	                    Medicine m1 = new Medicine();
	                    m1.displayMedicineTypes();
	                    int medicineChoice = s2.nextInt();
	                    Medicine.MedicineType medicineType = Medicine.MedicineType.ALLOPATHIC;
	                    switch (medicineChoice) {
	                        case 1:
	                            medicineType = Medicine.MedicineType.AYURVEDIC;
	                            break;
	                        case 2:
	                            medicineType = Medicine.MedicineType.ALLOPATHIC;
	                            break;
	                        case 3:
	                            medicineType = Medicine.MedicineType.HOMEOPATHIC;
	                            break;
	                        default:
	                            System.out.println("This Type is not available");
	                    }
	                    System.out.println("Enter Prize:");
	                    double prize = s2.nextDouble();
	                    Medicine m2 = new Medicine(name, brnadName, prize, medicineType);
	                    msc.addMedicine(m2);
	                    break;
	                case 2:
	                    msc.displayAllMedicine();
	                    break;
	                case 3:
	                    Scanner s3 = new Scanner(System.in);
	                    System.out.println("Enter Name to search:");
	                    String medicineName = s3.nextLine();
	                    msc.searchMedicine(medicineName);
	                    break;
	                case 4:
	                    Scanner s4 = new Scanner(System.in);
	                    System.out.println("Enter Name to search:");
	                    String medicineNameForUpdate = s4.nextLine();
	                    msc.updateMedicine(medicineNameForUpdate);
	                    break;
	                case 5:
	                    msc.deleteMedicine();
	                    break;
	                case 6:
	                    System.exit(0);

	                default:
	                    System.out.println("This Choice is not available");
	            }
	        } while (ch != 6);
	    }

	}