class Room {
    static int nextRoomNum=1;
    int roomNum;
    Character personInRoom;
    public Room() {
        roomNum=nextRoomNum++;

        if(roomNum==1) {
            personInRoom=new CharacterOne();
        }
        else if(roomNum==2) {
            personInRoom=new CharacterTwo();
        }
        else {
            personInRoom=new CharacterThree();
        }
        System.out.println("Welcome to room number" + roomNum);
        System.out.println("In here we have a fascinating character from popular movies...");
        System.out.println("Movie character, please tell us a little about yourself...");
        System.out.println();
        System.out.println(" "+personInRoom.getDescription());
        System.out.println(" "+personInRoom.greeting());
        System.out.println();
    }
    void askForSecret() {
        System.out.println("Okay, movie character, tell me a secret");
        System.out.println();
        System.out.println(" "+personInRoom.getInformation());
        System.out.println();
    }
    void sayGoodbye() {
        System.out.println("Thank you "+personInRoom.getCharacterName());
        System.out.println();
        System.out.println(" "+personInRoom.sayGoodbye());
        System.out.println();
    }
    void guessWho(String nameGuess) {
        if(personInRoom.guessWho(nameGuess))
        {
            System.out.println("Congratulations you guessed "+nameGuess+" correctly.");
            System.out.println(" "+personInRoom.getCharacterName()+" says "+personInRoom.sayGoodbye());
        }
        else {
            System.out.println("I'm sorry it's not "+nameGuess+" it was "+personInRoom.getCharacterName());
            System.out.println(" "+personInRoom.getCharacterName()+" says "+personInRoom.sayGoodbye());
        }
    }
}