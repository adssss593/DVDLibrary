package com.aj.dvd.ui;

import com.aj.dvd.dto.DVD;

import javax.swing.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class View {
    UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public void displayMenu() {
        System.out.println(
                "1.Add a DVD\n" +
                        "2.Remove a DVD\n" +//""
                        "3.Edit a DVD's info\n" + //""
                        "4.List all DVDs\n" +
                        "5.Display a DVD's info\n" +
                        "6.Search for a DVD\n" +
                        "7.Exit");
    }

    public int getUserChoice() {
        return io.readInt("Please choose an option", 1, 7);
    }

    public DVD getNewDVD() {
        String title = io.readString("Enter Title");
        String date = io.readString("Enter release date (dd/mm/yyy)");
        String rating = io.readString("Enter MPPA rating");
        String director = io.readString("Enter director");
        String studio = io.readString("Enter studio");
        String comment = io.readString("Any further film remarks?");

        DVD dvd = new DVD(title,date,rating,director,studio,comment);

        return dvd;
    }

    public boolean addDVDSuccess() {
        int userChoice = io.readInt("DVD added successfully" +
                "\n1.Add another" +
                "\n2.Main menu", 1, 2);
        return userChoice == 1;
    }

    public String getTitle() {
        return io.readString("Enter DVD title:");
    }

    public boolean dvdRemoveMessage(DVD dvd) {
        int userChoice;
        if (dvd != null) {
            userChoice = io.readInt("DVD removed, " +
                    "\n1.Remove another " +
                    "\n2.Main menu", 1, 2);
        } else {
            userChoice = io.readInt("DVD doesn't exist! " +
                    "\n1.Delete something else? " +
                    "\n2.Main menu", 1, 2);
        }
        return userChoice == 1;
    }

    public void listDVDs(Collection<String> titles) {
        if (titles.size() != 0) {
            for (String title : titles) {
                io.print(title);
            }
        } else {
            io.print("There are no films!!");
        }
        io.readString("Press enter to continue");
    }

    public void displayDVDInfo(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.toString());
        } else {
            io.print("DVD doesn't exist");
        }
        io.readString("Press enter to continue");
    }

    public void dvdSearch(DVD dvd) {
        if (dvd != null) {
            int userChoice = io.readInt("DVD exists! Would you like to view its info?" +
                    "\n1.Yes\n2.No, take me back to main menu", 1, 2);
            if (userChoice == 1) {
                displayDVDInfo(dvd);
            }
        } else {
            io.readString("DVD does not exist, press enter to continue.");
        }
    }

    public DVD editDVD(DVD dvd) {
        boolean keepEditing = true;
        do {
            int userChoice = io.readInt("What would you like to change?" +
                    "\n1.Tile" +
                    "\n2.Release Date" +
                    "\n3.MPPA rating" +
                    "\n4.Director" +
                    "\n5.Studio" +
                    "\n6.Further remarks", 1, 6);

            switch (userChoice) {
                case 1:
                    String newTitle = io.readString("New title: ");
                    dvd.setTitle(newTitle);
                    updateStatement();
                    break;
                case 2:
                    String newRelease = io.readString("New release date: ");
                    dvd.setReleaseData(newRelease);
                    updateStatement();
                    break;
                case 3:
                    String newMPPARating = io.readString("New rating:");
                    dvd.setmPPARating(newMPPARating);
                    updateStatement();
                    break;
                case 4:
                    String newDirector = io.readString("New director:");
                    dvd.setDirector(newDirector);
                    updateStatement();
                    break;
                case 5:
                    String newStudio = io.readString("New studio: ");
                    dvd.setStudio(newStudio);
                    updateStatement();
                    break;
                case 6:
                    String newRemarks = io.readString("New remarks:");
                    dvd.setUserNote(newRemarks);
                    updateStatement();
                    break;
            }
            int moreEditing = io.readInt("Would you like to edit something else?" +
                    "\n1.Yes" +
                    "\n2.No", 1, 2);
            if (moreEditing == 2) {
                keepEditing = false;
            }
        } while (keepEditing);
        io.readString("Finished editing, press enter to continue");
        return dvd;
    }

    public void updateStatement() {
        io.print("Updated.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void exitingMessage() {
        io.print("exiting...");
    }

    public void defaultMessage() {
        io.print("Please select one of the above options.");
    }
}

