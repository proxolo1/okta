/*!
 * Copyright (c) 2018, Okta, Inc. and/or its affiliates. All rights reserved.
 * The Okta software accompanied by this notice is provided pursuant to the Apache License, Version 2.0 (the "License.")
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 */

import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Inject } from '@angular/core';
import { OKTA_AUTH } from '@okta/okta-angular';
import { OktaAuth } from '@okta/okta-auth-js';

interface Claim {
  claim: string;
  value: unknown;
}

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  claims: Claim[] = [];

  constructor(
    @Inject(OKTA_AUTH) public oktaAuth: OktaAuth,
    private http: HttpClient
  ) {}

  async ngOnInit() {
    const userClaims = await this.oktaAuth.getUser();
   
    console.log(userClaims);
    this.claims = Object.entries(userClaims).map((entry) => ({
      claim: entry[0],
      value: entry[1],
    }));
  }
}
