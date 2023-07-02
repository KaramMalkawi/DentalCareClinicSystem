# DentalCareClinicSystem

This is a dental care clinic system implemented in Java. It provides a comprehensive solution for managing various tasks and interactions within a dental care clinic, including patient management, appointment scheduling, treatment tracking, and billing.

## Features

- **Patient Management:** Easily add, update, and retrieve patient information, including personal details, medical history, and contact information.
- **Appointment Scheduling:** Efficiently schedule appointments for patients, taking into account doctor availability and patient preferences.
- **Treatment Tracking:** Keep track of treatments and procedures performed on patients, including recording details, progress, and outcomes.
- **Billing and Invoicing:** Generate bills and invoices for patients based on the services rendered, enabling accurate and streamlined financial management.
- **Reporting and Analytics:** Generate reports and analyze data to gain insights into clinic operations, patient trends, and financial performance.

## SOLID Principles

The DentalCareClinicSystem project adheres to the SOLID principles of software design:

- **Single Responsibility Principle (SRP):** Each class in the project has a specific responsibility, promoting maintainable code.
- **Open-Closed Principle (OCP):** The project allows the addition of new patient types without modifying existing code, following the OCP. The use of the Strategy pattern and interfaces enables easy extension without affecting the existing system behavior.
- **Liskov Substitution Principle (LSP):** The project ensures that subclasses of the Patient class can be used interchangeably without altering the correctness of the system. The inheritance hierarchy of Patient subclasses (DentalConsultant, DentistStudent, OrdinaryPatient) maintains the expected behavior and properties of the Patient class.
- **Interface Segregation Principle (ISP):** Role-specific interfaces such as DoctorInterface, NurseInterface, and ReceptionistInterface promote modularity and clarity in the project. Each class adheres to the contract defined by its respective interface.
- **Dependency Inversion Principle (DIP):** The project depends on abstractions rather than concrete implementations, facilitating loose coupling and easier maintenance.

## Class Diagram

The class diagram for the DentalCareClinicSystem showcases the relationships between different classes. Here's an overview of the identified relations:

- Generalization (Inheritance):
  - The **Person** class serves as the base class for both **Patient** and **Staff**, representing individuals in the clinic. This inheritance relationship captures the shared attributes and behaviors of people in the system.
  - The **Patient** class is further specialized into subclasses such as **DentalConsultant**, **DentistStudent**, and **OrdinaryPatient**, each with additional attributes and behaviors.
  - The **Staff** class is also specialized into subclasses including **Doctor**, **Nurse**, and **Receptionist**, representing different roles within the clinic.

- Realization:
  - The **Strategy** class is realized by the subclasses of **Patient**. Each patient subclass implements a specific strategy defined by the **Strategy** class.
  - The **Receptionist** class realizes the **ReceptionistInterface**, the **Nurse** class realizes the **NurseInterface**, and the **Doctor** class realizes the **DoctorInterface**.

- Association:
  - There is an association between the **Doctor** and **Patient** classes, representing the interaction between doctors and patients.
  - Similar associations exist between the **Nurse**, **Receptionist**, and **Patient** classes.

- Dependence:
  - The **Receptionist**, **Nurse**, and **Doctor** classes depend on the **Context** class for their functionality.
  - Additionally, there is a dependence relationship between the **Receptionist**, **Nurse**, **Doctor** classes, and the **ClinicFacade** class.

The class diagram provides a visual representation of the system's architecture and the relationships between different components.

## Design Patterns Used

- **Facade Design Pattern:** The ClinicFacade class represents the Facade design pattern. It simplifies interactions with the Dental Care Clinic System, hiding the complexities of the underlying subsystems. The ClinicFacade promotes modularity, reduces coupling, and simplifies client code.
- **Singleton Design Pattern:** The Doctor, Nurse, and Receptionist classes utilize the Singleton design pattern. By implementing the Singleton pattern, these classes ensure that only a single instance is created and shared throughout the system, improving resource efficiency.
- **Strategy Design Pattern:** The Strategy design pattern is employed in the billing calculation mechanism of the Dental Care Clinic System. The Context class uses different strategies (DentalConsultant, DentistStudent, OrdinaryPatient) to calculate bills based on the patient type. This design pattern allows for flexible addition of new patient types and promotes code extensibility.

## Contact

For any questions or inquiries, please contact Karam.Malkawi@hotmail.com or KaramMalka2001@gmail.com.
