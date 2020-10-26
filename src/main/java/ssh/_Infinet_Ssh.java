/*
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
package ssh;

import abstractions.DTOExpectSendPair;
import abstractions.DTOVariableConvertResult;
import java.util.Map;


/**
 * Vendor Mikrotik general ssh class
 * @noinspection unused
 */
public class _Infinet_Ssh extends GeneralSsh {

    /**
     * Constructor
     *
     * @param coordinates   - schedule, task, node, etc..
     * @param settings      - app settings
     * @param credentials   - credentials
     * @param jobs          - sorted jobs
     * @param variables     - variable list
     */
    public _Infinet_Ssh(Map<String, String> coordinates, Map<String, String> settings, Map<String, String> credentials, Map<String, Map<String, String>> jobs, Map<String, DTOVariableConvertResult> variables)
    {
        /*
         * Parent constructor
         */
        super(coordinates, settings, credentials, jobs, variables);
        /*
         * Set ENTER_CHARACTER
         */
        ENTER_CHARACTER = "\r\n";
        this.controlSeqences.put("%%SEQ(ENTER)%%", this.ENTER_CHARACTER);

    }   

}
