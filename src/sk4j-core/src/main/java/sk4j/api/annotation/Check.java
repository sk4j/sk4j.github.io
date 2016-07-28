package sk4j.api.annotation;

import sk4j.enums.ArtifactType;
import sk4j.enums.ProjectType;

public @interface Check {
	ProjectType[] projectType() default ProjectType.MAVEN;

	ArtifactType[] artifactType() default {};
}
