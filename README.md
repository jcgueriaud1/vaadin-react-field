# React integration - Vaadin Field

This project shows an example of how a Month Year calendar written in React can be integrated as a Flow Field that can be used in the Binder.

It manages:
- label
- helper text
- not helper component
- invalid state, error message and required indicator (there is still some issues)

You can also see an example of a Lit integration and see that the Java wrapper is almost the same with the interface `IReactAdapterComponent`.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar` (NOTE, replace
`myapp-1.0-SNAPSHOT.jar` with the name of your jar).
