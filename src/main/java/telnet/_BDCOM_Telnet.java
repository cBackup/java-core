package telnet;/*
 * This file is part of cBackup, network equipment configuration backup tool
 * Copyright (C) 2017, Oļegs Čapligins, Imants Černovs, Dmitrijs Galočkins
 *
 * cBackup is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import abstractions.DTOExpectSendPair;
import abstractions.DTOSendExpectPair;
import abstractions.DTOVariableConvertResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/*
 * Custom telnet init
 */
import expect4j.Expect4j;
import org.apache.commons.net.io.FromNetASCIIInputStream;
import org.apache.commons.net.io.ToNetASCIIOutputStream;
import org.apache.commons.net.telnet.EchoOptionHandler;
import org.apache.commons.net.telnet.SuppressGAOptionHandler;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TerminalTypeOptionHandler;

/**
 * Vendor Nortel general telnet class
 * @noinspection unused
 */
public class _BDCOM_Telnet extends GeneralTelnet  {

    /**
     * Constructor
     *
     * @param coordinates   - schedule, task, node, etc..
     * @param settings      - app settings
     * @param jobs          - sorted jobs
     * @param credentials   - credentials
     * @param variables     - variable list
     */
    public _BDCOM_Telnet(Map<String, String> coordinates, Map<String, String> settings, Map<String, String> credentials, Map<String, Map<String, String>> jobs, Map<String, DTOVariableConvertResult> variables)
    {
        /*
         * Parent constructor
         */
        super(coordinates, settings, credentials, jobs, variables);

        /*
         * Set ENTER_CHARACTER
         */
        this.ENTER_CHARACTER = "\r\n";
        this.controlSeqences.put("%%SEQ(ENTER)%%", this.ENTER_CHARACTER);
    }


    /**
     * Expect init
     * Send credentials
     * Get device prompt
     * Send commands
     *
     * @return Boolean
     * @noinspection Duplicates
     */
    @Override
    protected Boolean telnetAuth() {
        for(DTOExpectSendPair currentPair : this.telnetAuthSequence) {
            if(!this.executeAuth(currentPair)) {
                return false;
            }
        }
		try {
			this.expect.expect("#");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return true;
    }

}
