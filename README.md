# sidecar-data-plane-api

1. ```sbt package```
2. ```sbt 'set pgpPassphrase := Some(Array())' publishSigned```
3. ```sbt 'sonatypeRelease'```