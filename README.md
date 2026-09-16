# Unified Verificator

Standalone soft/hard assertion library for API and UI test automation, written for Java 21.
Inspired by the CATools `verify` extension, but decoupled from the CATools ecosystem.

## Features

- **Hard assertions** (`Verify`) — fail immediately on the first failed check.
- **Soft assertions** (`Verifier`) — queue up multiple checks and report all failures together when you call `verify()`.
- Type-specific verifiers: `Object`, `String`, `Boolean` (`Bool`), `Date`, `File`, `Collection`, `Map`, and numbers (`Int`, `Long`, `Float`, `Double`, `BigDecimal`).
- Built-in retry/wait support for checks against values that need time to settle (e.g. polling a UI element or an async API response).
- Readable PASS/FAIL console output, with optional ANSI colors and optional diffs for string mismatches.
- Custom failure messages with `String.format`-style placeholders.

## Installation

This is a Maven project (`groupId: io.unified`, `artifactId: unified-verificator`), published to GitHub Packages on release.

Add the repository and dependency to your consuming project's `pom.xml`:

```xml
<repositories>
    <repository>
        <id>github</id>
        <name>GitHub Packages</name>
        <url>https://maven.pkg.github.com/ZeroTull/unified-verificator</url>
    </repository>
</repositories>

<dependency>
    <groupId>io.unified</groupId>
    <artifactId>unified-verificator</artifactId>
    <version>1.0.0</version>
</dependency>
```

GitHub Packages requires authentication even for public packages. Add a `<server>` entry with a GitHub personal access token (`read:packages` scope) to `~/.m2/settings.xml`:

```xml
<servers>
    <server>
        <id>github</id>
        <username>YOUR_GITHUB_USERNAME</username>
        <password>YOUR_GITHUB_TOKEN</password>
    </server>
</servers>
```

In GitHub Actions, this is handled automatically via `actions/setup-java`'s `server-id`/`server-username`/`server-password` inputs and the built-in `GITHUB_TOKEN` — no manual token needed there.

Alternatively, build and install it into your local repository directly:

```bash
mvn clean install
```

## Usage

### Hard assertions — `Verify`

Use `Verify` when a failed check should stop the test immediately (like standard `assert*` calls).

```java
import io.unified.verify.hard.Verify;

Verify.String.equals(actualName, "John Doe");
Verify.Object.isNotNull(response);
Verify.Int.equals(response.getStatusCode(), 200);
Verify.Collection.isNotEmpty(items);
```

Each check throws an `AssertionError` right away if it fails, with a readable message such as:

```
FAIL ::> Verify Equals. Exp: 'John Doe', Act: 'Jane Doe'
```

You can supply a custom message (supports `String.format` placeholders):

```java
Verify.Int.equals(response.getStatusCode(), 200, "Expected status 200 for endpoint '%s'", endpoint);
```

### Soft assertions — `Verifier`

Use `Verifier` when you want to collect multiple failures from a single test step and report them all at once, instead of stopping at the first one.

```java
import io.unified.verify.soft.Verifier;

Verifier verifier = new Verifier();

verifier.String.equals(user.getName(), "John Doe");
verifier.Int.equals(user.getAge(), 30);
verifier.Bool.isTrue(user.isActive());

verifier.verify(); // throws AssertionError listing every failed check, if any
```

`Verifier` also supports:

- `verifier.verify(header)` — same as `verify()` but prefixes the report with a custom header.
- `verifier.verifyAny()` / `verifyAny(header)` — passes if **at least one** queued check passes.
- `verifier.verifyNone()` / `verifyNone(header)` — passes if **none** of the queued checks pass.

Each call to `verify()`, `verifyAny()`, or `verifyNone()` clears the queue afterward, so the `Verifier` instance can be reused for the next batch of checks.

### Available verifiers

Both `Verify` (hard) and `Verifier` (soft) expose the same set of typed verifiers:

| Field        | Type                          | Example checks                                                   |
|--------------|--------------------------------|--------------------------------------------------------------------|
| `Object`     | `Object`                      | `equals`, `notEquals`, `isNull`, `isNotNull`                       |
| `String`     | `String`                      | `equals`, `contains`, `startsWith`, `matches`, `isBlank`, `lengthEquals`, ... |
| `Bool`       | `Boolean`                     | `isTrue`, `isFalse`                                                |
| `Date`       | `Date` / temporal types       | `equals`, `isBefore`, `isAfter`                                    |
| `File`       | `File`                        | `exists`, `isDirectory`, `contentEquals`                           |
| `Collection` | `Collection<?>`               | `isEmpty`, `isNotEmpty`, `contains`, `sizeEquals`                  |
| `Map`        | `Map<?,?>`                    | `containsKey`, `containsValue`, `isEmpty`                          |
| `Int`/`Long`/`Float`/`Double`/`BigDecimal` | numbers | `equals`, `isGreaterThan`, `isLessThan`, `isBetween`                |

Every check method has an overload that accepts a custom failure message with `%s`/`%d`-style placeholders.

### Waiting / retrying checks

Checks can be configured to retry for a period of time before failing — useful for polling values that need time to become correct (e.g. waiting for a UI element or an eventually-consistent API response). Configure the default wait window via system properties (see below), or use the retry-aware overloads exposed on the verifier interfaces.

### Configuration

Behavior is controlled via `io.unified.verify.core.VerifyConfig`, which reads the following system properties:

| Property                                   | Default | Description                                      |
|---------------------------------------------|---------|--------------------------------------------------|
| `unified.verify.printPassed`                | `false` | Also log PASS lines, not just failures.           |
| `unified.verify.ansiColors`                 | `true`  | Colorize console output (only active in a terminal). |
| `unified.verify.defaultWaitSeconds`         | `30`    | Default timeout for retry-aware checks.           |
| `unified.verify.defaultWaitIntervalMillis`  | `500`   | Poll interval for retry-aware checks.             |

Example:

```bash
mvn test -Dunified.verify.printPassed=true -Dunified.verify.ansiColors=false
```

Or programmatically:

```java
VerifyConfig.setPrintPassed(true);
VerifyConfig.setAnsiColors(false);
```

## Building and testing

```bash
mvn clean test     # run the test suite
mvn clean install  # build the jar and install it locally
```

Requires Java 21 and Maven.

## Dependencies

- SLF4J (logging facade)
- Apache Commons Lang3 / Commons Collections4
- diff-match-patch (for diffed failure messages on string mismatches)
- Lombok (compile-time only)
- TestNG + AssertJ (test scope, for testing the library itself)
