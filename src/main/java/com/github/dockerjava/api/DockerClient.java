package com.github.dockerjava.api;

import java.io.*;

import com.github.dockerjava.api.command.AttachContainerCmd;
import com.github.dockerjava.api.command.AuthCmd;
import com.github.dockerjava.api.command.BuildImageCmd;
import com.github.dockerjava.api.command.CommitCmd;
import com.github.dockerjava.api.command.ContainerDiffCmd;
import com.github.dockerjava.api.command.CopyFileFromContainerCmd;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.command.CreateImageCmd;
import com.github.dockerjava.api.command.InfoCmd;
import com.github.dockerjava.api.command.InspectContainerCmd;
import com.github.dockerjava.api.command.InspectImageCmd;
import com.github.dockerjava.api.command.KillContainerCmd;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.command.LogContainerCmd;
import com.github.dockerjava.api.command.PauseContainerCmd;
import com.github.dockerjava.api.command.PingCmd;
import com.github.dockerjava.api.command.PullImageCmd;
import com.github.dockerjava.api.command.PushImageCmd;
import com.github.dockerjava.api.command.RemoveContainerCmd;
import com.github.dockerjava.api.command.RemoveImageCmd;
import com.github.dockerjava.api.command.RestartContainerCmd;
import com.github.dockerjava.api.command.SearchImagesCmd;
import com.github.dockerjava.api.command.StartContainerCmd;
import com.github.dockerjava.api.command.StopContainerCmd;
import com.github.dockerjava.api.command.TagImageCmd;
import com.github.dockerjava.api.command.TopContainerCmd;
import com.github.dockerjava.api.command.UnpauseContainerCmd;
import com.github.dockerjava.api.command.VersionCmd;
import com.github.dockerjava.api.command.WaitContainerCmd;
import com.github.dockerjava.api.model.AuthConfig;

// https://godoc.org/github.com/fsouza/go-dockerclient
public interface DockerClient extends Closeable {

	public AuthConfig authConfig() throws DockerException;

	/**
	 * Authenticate with the server, useful for checking authentication.
	 */
	public AuthCmd authCmd();

	public InfoCmd infoCmd();

	public PingCmd pingCmd();

	public VersionCmd versionCmd();

	/**
	 * * IMAGE API *
	 */

	public PullImageCmd pullImageCmd(String repository);

	public PushImageCmd pushImageCmd(String name);

	public CreateImageCmd createImageCmd(String repository,
			InputStream imageStream);

	public SearchImagesCmd searchImagesCmd(String term);

	public RemoveImageCmd removeImageCmd(String imageId);

	public ListImagesCmd listImagesCmd();

	public InspectImageCmd inspectImageCmd(String imageId);

	/**
	 * * CONTAINER API *
	 */

	public ListContainersCmd listContainersCmd();

	public CreateContainerCmd createContainerCmd(String image);

	public StartContainerCmd startContainerCmd(String containerId);

	public InspectContainerCmd inspectContainerCmd(String containerId);

	public RemoveContainerCmd removeContainerCmd(String containerId);

	public WaitContainerCmd waitContainerCmd(String containerId);

	public AttachContainerCmd attachContainerCmd(String containerId);

	public LogContainerCmd logContainerCmd(String containerId);

	public CopyFileFromContainerCmd copyFileFromContainerCmd(
			String containerId, String resource);

	public ContainerDiffCmd containerDiffCmd(String containerId);

	public StopContainerCmd stopContainerCmd(String containerId);

	public KillContainerCmd killContainerCmd(String containerId);

	public RestartContainerCmd restartContainerCmd(String containerId);

	public CommitCmd commitCmd(String containerId);

	public BuildImageCmd buildImageCmd(File dockerFolder);

	public BuildImageCmd buildImageCmd(InputStream tarInputStream);

	public TopContainerCmd topContainerCmd(String containerId);

	public TagImageCmd tagImageCmd(String imageId, String repository, String tag);
	
	public PauseContainerCmd pauseContainerCmd(String containerId);
	
	public UnpauseContainerCmd unpauseContainerCmd(String containerId);

	public void close() throws IOException;

}