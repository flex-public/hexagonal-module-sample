/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr

import java.time.Instant

interface AuditProps {
    val createdAt: Instant
    val updatedAt: Instant
}
