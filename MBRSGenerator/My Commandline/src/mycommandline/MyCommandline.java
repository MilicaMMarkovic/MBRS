/*
 * Copyright (c) 2014 NoMagic, Inc. All Rights Reserved.
 */
package mycommandline;

import com.nomagic.magicdraw.commandline.CommandLine;

/**
 * @author Martynas Lelevicius
 */
public class MyCommandline extends CommandLine
{

	@Override
	protected byte execute()
	{
		System.out.println("Executing my command line...");
		return 0;
	}
}
