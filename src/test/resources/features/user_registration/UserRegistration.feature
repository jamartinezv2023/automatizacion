Feature: User registration in Advantage Online Shopping

  Scenario: Successful user registration

    Given that the user opens the home page of the store

    When he interacts with the registration form entering the corresponding data
      | username       | email                    | password      | firstName | lastName         | phoneNumber | city    | address             | state | postalCode |
      | joseqa2026test | joseqa2026test@test.com | Calidad2026*  | Jose      | Martinez Valdes  | 3001234567  | Palmira | Carrera 43 # 46-40  | Valle | 763533 |

    Then the system should validate the successful creation of the profile on the platform