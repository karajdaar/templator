#! /bin/sh

#
# Copyright 2002 Sun Microsystems, Inc. All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
# - Redistributions of source code must retain the above copyright
#   notice, this list of conditions and the following disclaimer.
#
# - Redistribution in binary form must reproduce the above copyright
#   notice, this list of conditions and the following disclaimer in
#   the documentation and/or other materials provided with the
#   distribution.
#
# Neither the name of Sun Microsystems, Inc. or the names of
# contributors may be used to endorse or promote products derived
# from this software without specific prior written permission.
#
# This software is provided "AS IS," without a warranty of any
# kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
# WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
# EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES
# SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
# DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN
# OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR
# FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR
# PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF
# LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE,
# EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
#
# You acknowledge that Software is not designed, licensed or intended
# for use in the design, construction, operation or maintenance of
# any nuclear facility.
#


# $Id: build.sh,v 1.1.2.1.4.1 2002/11/01 18:27:33 zull Exp $

if [ -z "$JAVA_HOME" ]
then
JAVACMD=`which java`
if [ -z "$JAVACMD" ]
then
echo "Cannot find JAVA. Please set your PATH."
exit 1
fi
JAVA_BINDIR=`dirname $JAVACMD`
JAVA_HOME=$JAVA_BINDIR/..
fi

if [ -z "$J2EE_HOME" ]
then
echo "Please set J2EE_HOME."
exit 1
fi

JAVACMD=$JAVA_HOME/bin/java

ANT_HOME=lib/ant
ANT_CLASSPATH=$JAVA_HOME/lib/tools.jar
ANT_CLASSPATH=$ANT_HOME/lib/ant.jar:$ANT_HOME/lib/jaxp.jar:$ANT_HOME/lib/parser.jar:$ANT_CLASSPATH
ANT_CLASSPATH=$J2EE_HOME/lib/j2ee.jar:$ANT_CLASSPATH
$JAVACMD -classpath $ANT_CLASSPATH -Dant.home=$ANT_HOME -Dj2ee.home=$J2EE_HOME -Dj2ee-script-suffix= org.apache.tools.ant.Main "$@"
