package pt.upskills.projeto.game;
/*
switch (mov) {
			case "U": case"u": case"8":
				Vector2D v = Direction.UP.asVector();
				char a = abrir_ficheiro(ficheiro).get(name.getPosition().getY() - 1).charAt(name.getPosition().getX());
				switch (a){
					case 'W':
						System.out.println("You cant move there !!!");
						break;
					case 'E':
						System.out.println("You picked up the sword of destiny young warrior");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setDamage(3);
						break;
					case 'M':
						System.out.println("Yummy Yummy");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setHealth(5);
						break;
					case 'H':
						System.out.println("Well done THOR!!!");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setDamage(7);
						break;
					case 'k':
						System.out.println("Be carefull you have encountered a living death mofo");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setHealth(-3);
						break;
					case 'F':
						System.out.println("ufff it burns");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setHealth(-1);
						break;
					case 'B':
						System.out.println("nananananananana batman batman");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setHealth(-2);
						break;
					case 'e':
						System.out.println("Bad Guy Incoming!!!");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setHealth(-7);
						break;
					case 'T':
						System.out.println("Watch your feet");
						name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
						name.setHealth(-3);
						break;
						/*
					case 's':
						tiles.add(new StairsDown(new Position(i, j)));
						break;
					case 'K':
						tiles.add(new Key(new Position(i, j)));
						break;
					case 'G':
						tiles.add(new Grass(new Position(i, j)));
						break;
					case 'O':
						tiles.add(new DoorOpen(new Position(i, j)));
						break;
					case 'o':
						tiles.add(new DoorClosed(new Position(i, j)));
						break;
					case 'w':
						tiles.add(new DoorWay(new Position(i, j)));
						break;
					case 'S':
						tiles.add(new StairsUp(new Position(i, j)));
						break;
					case 't':
						tiles.add(new Thief(new Position(i, j)));
						break;
					case 'r':
						tiles.add(new Red(new Position(i, j)));
						break;
					case 'g':
						tiles.add(new Green(new Position(i, j)));
						break;
					case 'b':
						tiles.add(new Black(new Position(i, j)));
						break;


					case ' ':
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1));
							break;
							}
							break;

							case "D": case "d":case"2":
							Vector2D v2 = Direction.DOWN.asVector();
							char a2 = abrir_ficheiro(ficheiro).get(name.getPosition().getY() + 1).charAt(name.getPosition().getX());

							switch (a2){
							case 'W':
							System.out.println("You cant move there !!!");
							break;
							case 'E':
							System.out.println("You picked up the sword of destiny young warrior.");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setDamage(3);
							break;
							case 'M':
							System.out.println("Yummy Yummy");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setHealth(5);
							break;
							case 'H':
							System.out.println("Well done THOR!!!");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setDamage(7);
							break;
							case 'k':
							System.out.println("Be carefull you have encountered a living death mofo");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setHealth(-3);
							break;
							case 'F':
							System.out.println("ufff it burns");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setHealth(-1);
							break;
							case 'B':
							System.out.println("nananananananana batman batman");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setHealth(-2);
							break;
							case 'e':
							System.out.println("Bad Guy Incoming!!!");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setHealth(-7);
							break;
							case 'T':
							System.out.println("Watch your feet");
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							name.setHealth(-3);
							break;

					case 's':
						tiles.add(new StairsDown(new Position(i, j)));
						break;
					case 'K':
						tiles.add(new Key(new Position(i, j)));
						break;
					case 'G':
						tiles.add(new Grass(new Position(i, j)));
						break;
					case 'O':
						tiles.add(new DoorOpen(new Position(i, j)));
						break;
					case 'o':
						tiles.add(new DoorClosed(new Position(i, j)));
						break;
					case 'w':
						tiles.add(new DoorWay(new Position(i, j)));
						break;
					case 'S':
						tiles.add(new StairsUp(new Position(i, j)));
						break;
					case 't':
						tiles.add(new Thief(new Position(i, j)));
						break;
					case 'r':
						tiles.add(new Red(new Position(i, j)));
						break;
					case 'g':
						tiles.add(new Green(new Position(i, j)));
						break;
					case 'b':
						tiles.add(new Black(new Position(i, j)));
						break;


							case ' ':
							name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1));
							break;

							}
							break;

							case "L": case "l":case"4":
							Vector2D v3 =Direction.LEFT.asVector();
							char a3 = abrir_ficheiro(ficheiro).get(name.getPosition().getY()).charAt(name.getPosition().getX() -1 );
							switch (a3){
							case 'W':
							System.out.println("You cant move there !!!");
							break;
							case 'E':
							System.out.println("You picked up the sword of destiny young warrior");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							break;
							case 'M':
							System.out.println("Yummy Yummy");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							name.setHealth(5);
							break;
							case 'H':
							System.out.println("Well done THOR!!!");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							name.setDamage(7);
							break;
							case 'k':
							System.out.println("Be carefull you have encountered a living death mofo");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							name.setHealth(-3);
							break;
							case 'F':
							System.out.println("ufff it burns");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							name.setHealth(-1);
							break;
							case 'B':
							System.out.println("nananananananana batman batman");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							name.setHealth(-2);
							break;
							case 'e':
							System.out.println("Bad Guy Incoming!!!");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							name.setHealth(-7);
							break;
							case 'T':
							System.out.println("Watch your feet");
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							name.setHealth(-3);
							break;

					case 's':
						tiles.add(new StairsDown(new Position(i, j)));
						break;
					case 'K':
						tiles.add(new Key(new Position(i, j)));
						break;
					case 'G':
						tiles.add(new Grass(new Position(i, j)));
						break;
					case 'O':
						tiles.add(new DoorOpen(new Position(i, j)));
						break;
					case 'o':
						tiles.add(new DoorClosed(new Position(i, j)));
						break;
					case 'w':
						tiles.add(new DoorWay(new Position(i, j)));
						break;
					case 'S':
						tiles.add(new StairsUp(new Position(i, j)));
						break;
					case 't':
						tiles.add(new Thief(new Position(i, j)));
						break;
					case 'r':
						tiles.add(new Red(new Position(i, j)));
						break;
					case 'g':
						tiles.add(new Green(new Position(i, j)));
						break;
					case 'b':
						tiles.add(new Black(new Position(i, j)));
						break;


							case ' ':
							name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()  ));
							break;
							}
							break;

							case "R": case "r":case"6":
							Vector2D v4 =Direction.RIGHT.asVector();
							char a4 = abrir_ficheiro(ficheiro).get(name.getPosition().getY()).charAt(name.getPosition().getX() +1 );
							switch (a4){
							case 'W':
							System.out.println("You cant move there !!!");
							break;
							case 'E':
							System.out.println("You picked up the sword of destiny young warrior");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							break;

							case 'M':
							System.out.println("Yummy Yummy");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							name.setHealth(5);
							break;
							case 'H':
							System.out.println("Well done THOR!!!");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							name.setDamage(7);
							break;
							case 'k':
							System.out.println("Be carefull you have encountered a living death mofo");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							name.setHealth(-3);
							break;
							case 'F':
							System.out.println("ufff it burns");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							name.setHealth(-1);
							break;
							case 'B':
							System.out.println("nananananananana batman batman");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							name.setHealth(-2);
							break;
							case 'e':
							System.out.println("Bad Guy Incoming!!!");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							name.setHealth(-7);
							break;
							case 'T':
							System.out.println("Watch your feet");
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							name.setHealth(-3);
							break;

					case 's':
						tiles.add(new StairsDown(new Position(i, j)));
						break;
					case 'K':
						tiles.add(new Key(new Position(i, j)));
						break;
					case 'G':
						tiles.add(new Grass(new Position(i, j)));
						break;
					case 'O':
						tiles.add(new DoorOpen(new Position(i, j)));
						break;
					case 'o':
						tiles.add(new DoorClosed(new Position(i, j)));
						break;
					case 'w':
						tiles.add(new DoorWay(new Position(i, j)));
						break;
					case 'S':
						tiles.add(new StairsUp(new Position(i, j)));
						break;
					case 't':
						tiles.add(new Thief(new Position(i, j)));
						break;
					case 'r':
						tiles.add(new Red(new Position(i, j)));
						break;
					case 'g':
						tiles.add(new Green(new Position(i, j)));
						break;
					case 'b':
						tiles.add(new Black(new Position(i, j)));
						break;


							case ' ':
							name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()));
							break;
							}
							break;

							case " ":
							//Atacar
							break;
							case "exit":
							System.out.println("Thank you for playing \uD83D\uDC8B\uD83D\uDC8B\uD83D\uDC8B  ");
							System.exit(0);
							case "Next Level":
							System.out.println("Are you cheating ???");
							break;
							case "Previous Level":
							System.out.println("You liked it that much ???");
							break;
default:
		System.out.println("Invalid Move !!!");
		}
		*/

