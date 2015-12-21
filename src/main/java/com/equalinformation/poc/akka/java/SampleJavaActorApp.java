package com.equalinformation.poc.akka.java;

/**
 * Created by bpupadhyaya on 12/20/15.
 */
public class SampleJavaActorApp {
    public static void main(String[] args) {
        akka.Main.main(new String[] { SampleJavaActor.class.getName() });
    }
}
